/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author gokil
 */
import java.util.*;


// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph

 
public class SimpleDijkstra
{
    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static int V;
    static int[] minimDistance ;
    static int mini(Boolean[] hasFound)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 1; v <= V; v++)
            if (hasFound[v] == false && minimDistance[v] <= min)
            {
                min = minimDistance[v];
                min_index = v;
            }
 
        return min_index;
    }

 
    // Funtion that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    static void dijkstra(int graph[][], int src)
    {
        // The output array. minimDistance[i] will hold
                                 // the shortest distance from src to i
 
        // hasFound[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean[] hasFound = new Boolean[V+5];
 
        // Initialize all distances as INFINITE and hasFound[] as false
        for (int i = 1; i <= V; i++)
        {
            minimDistance[i] = Integer.MAX_VALUE;
            hasFound[i] = false;
        }
 
        // Distance of source vertex from itself is always 0
        minimDistance[src] = 0;
 
        // Find shortest path for all vertices
        for (int count = 1; count < V; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = mini(hasFound);
 
            // Mark the picked vertex as processed
            hasFound[u] = true;
 
            // Update minimDistance value of the adjacent vertices of the
            // picked vertex.
            for (int v = 1; v <= V; v++)
 
                // Update minimDistance[v] only if is not in hasFound, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of minimDistance[v]
                if (!hasFound[v] && graph[u][v]!=0 &&
                        minimDistance[u] != Integer.MAX_VALUE &&
                        minimDistance[u]+graph[u][v] < minimDistance[v])
                    minimDistance[v] = minimDistance[u] + graph[u][v];
        }
 

    }
 
    // Driver method
    public static void main (String[] args)
    {
        Scanner input=new Scanner(System.in);
       int graph[][] = new int[1000][1000];
        System.out.print("Enter the number of Vertex : ");V=input.nextInt();
        minimDistance=new int[V+5];
        System.out.println(V+" (1--"+V+")Vertexs have been created");
        int dest,source,distance;
        int edge;
        System.out.print("Enter the number of Edge : "); edge=input.nextInt();
        System.out.println("Enter all of Edge with the distance");
        for(int i=1;i<=edge;i++){
            System.out.println("Edge #"+i);
            System.out.print("Source Vertex : ");source=input.nextInt();
            System.out.print("Destination Vertex : ");dest=input.nextInt();
            System.out.print("The distance of between two vertex :");distance= input.nextInt();
            graph[source][dest]=distance;
        }
        int srcVertex,dstVertex;
        System.out.print("Enter your first Vertex : ");srcVertex=input.nextInt();
        System.out.print("Enter your destination Vertex : ");dstVertex=input.nextInt();
        
        dijkstra(graph, srcVertex);
        System.out.println("The distance from Vertex "+srcVertex+" to Vertex "+dstVertex+" is "+minimDistance[dstVertex]);
    }
}
