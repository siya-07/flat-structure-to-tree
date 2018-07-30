package za.co.mamamoney;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import za.co.mamamoney.model.Node;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String... args) {
		ArrayList<Node> nodes = new ArrayList<Node>() {
			private static final long serialVersionUID = 1L;
			{
				add(new Node(123L, "NodeB", 7000L));
				add(new Node(7000L, "NodeA", 0L));
				add(new Node(9L, "NodeC", 123L));
				add(new Node(3L, "NodeF", 0L));
				add(new Node(25L, "NodeE", 7000L));
				add(new Node(2L, "NodeD", 7000L));
				add(new Node(10L, "NodeG", 3L));
			}
		};

		
		printTree(nodes);
	}
	
	static ArrayList<Node> buildTree(ArrayList<Node> nodes) {
		Map<Long, Node> map = new HashMap<>();
		for (Node current : nodes)
			map.put(current.getId(), current);
		
        for (Integer i = nodes.size()-1;i>=0;i--) {
            Long parentId = nodes.get(i).getParentId();
 
            if (parentId != 0) {
                Node parent = map.get(parentId);
                if (parent != null) {
                	nodes.get(i).setParent(parent);
                    parent.addChild(nodes.get(i));
                    map.put(parentId, parent);
                    map.put(nodes.get(i).getId(), nodes.get(i));
                }
                
                nodes.remove(nodes.get(i));
            }
        }
        map = null;
		return nodes;
	}

	static void printTree(ArrayList<Node> nodes,int generation) {
		for(Node n:nodes) {
			for(int i=0;i<generation;i++)
				System.out.print("  ");
			System.out.println(n);
			if(n.getChildren() != null)
				printTree(n.getChildren(),generation+1);
		}
	}
	
	static void printTree(ArrayList<Node> nodes) {
		ArrayList<Node> tree = buildTree(nodes);
		printTree(tree,0);
	}
}