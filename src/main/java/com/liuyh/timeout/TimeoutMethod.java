package com.liuyh.timeout;

public class TimeoutMethod {
	private String name;
	private long cost;
	private String args;
	private int level;

	public TimeoutMethod() {
		super();
	}

	public TimeoutMethod(String name, long cost, String args, int level) {
		super();
		this.name = name;
		this.cost = cost;
		this.args = args;
		this.level = level;
	}

	@Override
	public String toString() {
		if (this.level == 0)
			return name + ", cost=" + cost + "ms, args=" + args;
		else {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < this.level; i++) {
				sb.append("\t");
			}
			return sb.toString() + "-" + name + ", cost=" + cost + "ms, args=" + args;
		}
	}

}
