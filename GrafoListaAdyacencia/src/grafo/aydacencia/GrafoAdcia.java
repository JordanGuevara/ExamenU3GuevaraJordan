package grafo.aydacencia;

public class GrafoAdcia {
	
	int numVerts;
	static int maxVerts = 20;
	VerticeAdy [] tablAdc;
	
	public GrafoAdcia(int mx) {
		tablAdc = new VerticeAdy[mx];
		numVerts = 0;
		maxVerts = mx;
	}
	
	
	// Agregar la metodo que permite agregar un nuevo vertice
	/*
	 * Dirigido 
	 * Añade un nuevo vertice a la lista directorio. Si el vertice ya este en la tabla no hace nada, 
	 * devuelve control; si es nuevo, se asigna a continuacion del ultimo. 
	 */
	
	public void agregarVertice(String nombreCiudad) {
        if (numVerts < maxVerts) {
            tablAdc[numVerts++] = new VerticeAdy(nombreCiudad);
        }
    }
	//Agregar metodo que permite agregar un nuevo arco
	/*
	 * Esta operacion da entrada a un arco del grafo. El metodo tiene como entrada el vertice origen y el 
	 * vertice destino. El metodo adyacente() determina si la arista ya esto en la lista de adyacencia, 
	 * y, por  ultimo, el Arco se inserta en la lista de adyacencia del nodo origen. 
	 * La insercion se hace como primer nodo para que el tiempo sea constante, O(1). 
	 * Otra version del metodo recibe, directamente, los numeros de vertices que forman los extremos del arco. 
	 * ara añadir una arista en un grafo valorado, se debe asignar el factor de peso al crear el Arco.
	 */
	public void agregarArco(int origen, int destino) {
        if (origen >= 0 && origen < numVerts && destino >= 0 && destino < numVerts) {
            if (!sonAdyacentes(origen, destino)) {
                tablAdc[origen].lad.add(new Arco(destino));
            }
        }
    }

    public void agregarArco(int origen, int destino, double peso) {
        if (origen >= 0 && origen < numVerts && destino >= 0 && destino < numVerts) {
            if (!sonAdyacentes(origen, destino)) {
                tablAdc[origen].lad.add(new Arco(destino, peso));
            }
        }
    }
	//Agregar un metodo que determina si dos vertices son adyacentes
	/*
	 * La operacion determina si dos vertices, v1 y v2, forman un arco. En definitiva, 
	 * si el vertice v2 esto en la lista de adyacencia de v1. 
	 * El metodo buscarLista() devuelve la direccion del nodo que contiene al arco, si no esto devuelve null. 
	 */
    public boolean sonAdyacentes(int v1, int v2) {
        if (v1 >= 0 && v1 < numVerts && v2 >= 0 && v2 < numVerts) {
            for (Object arco : tablAdc[v1].lad) {
                if (((Arco) arco).getDestino() == v2) {
                    return true;
                }
            }
        }
        return false;
    }
	
	/*
	 * Metodo de profundidad del grafo
	 */
	public void dfs(int inicio) {
        boolean[] visitados = new boolean[numVerts];
        profundidad(inicio, visitados);
    }

    private void profundidad(int vertice, boolean[] visitados) {
        visitados[vertice] = true;
        System.out.print(tablAdc[vertice].nomVertice() + " ");
        for (Object arco : tablAdc[vertice].lad) {
            int destino = ((Arco) arco).getDestino();
            if (!visitados[destino]) {
                profundidad(destino, visitados);
            }
        }
    }

}
