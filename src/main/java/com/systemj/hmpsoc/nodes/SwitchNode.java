package com.systemj.hmpsoc.nodes;

import java.io.PrintWriter;

import com.systemj.hmpsoc.DeclaredObjects;
import com.systemj.hmpsoc.MemoryPointer;

public class SwitchNode extends BaseGRCNode {
	private String CDName;
	private String Statename;
	private int CDid;

	public String getStatename() {
		return Statename;
	}

	public void setStatename(String statename) {
		Statename = statename;
	}

	public String getCDName() {
		return CDName;
	}

	public void setCDName(String cDName) {
		CDName = cDName;
	}

	@Override
	public String dump(int indent) {
		String str = "";
		String ind = getIndent(indent,'-');
		str += ind +"SwitchNode\n";
		ind = getIndent(indent);
		str += ind + "Statename: "+ Statename + "\n";
		
		for(BaseGRCNode child : children){
			str += child.dump(indent+1);
		}
		
		return str;
	}

	@Override
	public void weirdPrint(PrintWriter pw, MemoryPointer mp, int termcode, int cdi, BaseGRCNode directParent, DeclaredObjects doo) {
		pw.println("  LDR R10 $"+Long.toHexString(mp.getSwitchNodePointer()+mp.switchMap.get(Statename)));
		pw.println("  JMP R10; Jump to this switch child");
		
		for(int i=0; i<children.size(); i++){
			pw.print(Statename.toLowerCase()+"_"+i);
			this.getChild(i).weirdPrint(pw, mp, termcode, cdi, this, doo);
			pw.println("  JMP SWITCHEND_"+Statename);
		}
		pw.println("SWITCHEND_"+Statename);
	}

	public int getCDid() {
		return CDid;
	}

	public void setCDid(int cDid) {
		CDid = cDid;
	}


	
}
