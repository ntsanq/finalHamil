package Hamilton;

import java.util.ArrayList;
class Connectivity
{
    // A user define class to represent a graph.
    // A graph is an array of adjacency lists.
    // Size of array will be V (number of vertices
    // in graph)
    int V;
    ArrayList<ArrayList<Integer> > adjListArray;
 
    // constructor
    Connectivity(int V)
    {
        this.V = V;
        // define the size of array as
        // number of vertices
        adjListArray = new ArrayList<>();
 
        // Create a new list for each vertex
        // such that adjacent nodes can be stored
 
        for (int i = 0; i < V; i++) {
            adjListArray.add(i, new ArrayList<>());
        }
    }
 
    // Adds an edge to an undirected graph
    void addEdge(int src, int dest)
    {
        // Add an edge from src to dest.
        adjListArray.get(src).add(dest);
 
        // Since graph is undirected, add an edge from dest
        // to src also
        adjListArray.get(dest).add(src);
    }
 
    public static String connectString = "";
    
    void DFSUtil(int v, boolean[] visited)
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        if(v!=0){
            System.out.print(v + " ");
            connectString += v + " ";
        }
        
        // Recur for all the vertices
        // adjacent to this vertex
        for (int x : adjListArray.get(v)) {
            if (!visited[x])
                DFSUtil(x, visited);
        }
    }
    void connectedComponents()
    {
        connectString = "";
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        for (int v = 1; v < V; ++v) {
            if (!visited[v]) {
                // print all reachable vertices
                // from v
                        DFSUtil(v, visited);
                        
                        connectString =  connectString + ". "; 
              
            }
        }

    }
    

}