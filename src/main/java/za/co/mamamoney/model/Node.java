package za.co.mamamoney.model;

import java.util.ArrayList;

public class Node {
    private Long id;
    private String label;
    private Long parentId;
    private Node parent;
    private ArrayList<Node> children;
    
    public Node(){}
    
    public Node(Long id, String label,Long parentId){
        this.id = id;
        this.label = label;
        this.parentId = parentId;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public ArrayList<Node> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}
	
	public void addChild(Node child) {
		if(this.children == null) this.setChildren(new ArrayList<Node>());
	    if (!this.children.contains(child) && child != null)
	        this.children.add(child);
	}

	@Override
	public String toString() {
		return this.label +" (id:" + id + ", parentId:" + parentId + ")";
	}

}

