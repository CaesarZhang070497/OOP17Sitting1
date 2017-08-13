public class App {
	private int memory; //Memory requirement
	private	int cpu; //Cpu requirement
	private	String name; // App name
	public App(String n, int m, int c) { 
		memory = m;
		cpu   = c;
		name  = n;
	}
	public int getMemoryReq() { return memory; }
	public int getCpuReq() { return cpu; }
	public String getName() { return name; }
}
