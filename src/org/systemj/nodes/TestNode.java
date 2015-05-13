package org.systemj.nodes;

public class TestNode extends BaseGRCNode {
	private String expr;
	private boolean javastmt;

	public String getExpr() {
		return expr;
	}

	public void setExpr(String expr) {
		this.expr = expr;
	}

	@Override
	public String dump(int indent) {
		String str = "";
		String ind = getIndent(indent,'-');
		str += ind +"TestNode\n";
		ind = getIndent(indent);
		str += ind + "Expr: "+ expr + "\n";
		if(isJavastmt())
			str += ind + "Java If"+ "\n";
		
		for(BaseGRCNode child : children){
			str += child.dump(indent+1);
		}
		
		return str;
	}

	public boolean isJavastmt() {
		return javastmt;
	}

	public void setJavastmt(boolean javastmt) {
		this.javastmt = javastmt;
	}

}