package com.systemj.hmpsoc.util;

import java.io.PrintWriter;

public class IndentPrinter {

	private int indentLevel;
	private String indent;
	private PrintWriter out;
	private static String defaultIndent = "    ";

	public IndentPrinter() {
		this(new PrintWriter(System.out));
	}

	public IndentPrinter(PrintWriter out) {
		this(out, defaultIndent);
	}

	public IndentPrinter(PrintWriter out, String indent) {
		this.out = out;
		this.indent = indent;
	}

	public void println() {
		out.println();
	}

	public void println(Object value) {
		println(value.toString());
	}

	public void println(String text) {
		printIndent();
		out.println(text);
	}

	public void printIndent() {
		for (int i = 0; i < indentLevel; i++) {
			out.print(indent);
		}
	}

	public void print(String text) {
		out.print(text);
	}

	public void incrementIndent() {
		++indentLevel;
	}

	public void decrementIndent() {
		--indentLevel;
	}

	public int getIndentLevel() {
		return indentLevel;
	}

	public void setIndentLevel(int indentLevel) {
		this.indentLevel = indentLevel;
	}

	public void flush() {
		out.flush();
	}

	public void close() {
		out.close();
	}

	public String getIndentString() {
		String s = "";
		for (int i = 0; i < indentLevel; i++) {
			s += indent;
		}
		return s;
	}
	
	public static String getIndentString(int j) {
		String s = "";
		for (int i = 0; i < j; i++) {
			s += defaultIndent;
		}
		return s;
	}
}
