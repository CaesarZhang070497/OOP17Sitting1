import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FruitySmartPhone extends Phone{
	private static HashMap<String,Integer> installedApps = new HashMap<String,Integer>();;
	private int cpuSpeed;
	private int freeMemory;
	public int getCpuSpeed() {
		return cpuSpeed;
	}
	public void setCpuSpeed(int cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}
	public int getFreeMemory() {
		return freeMemory;
	}
	public void setFreeMemory(int freeMemory) {
		this.freeMemory = freeMemory;
	}
	public FruitySmartPhone(String name, int availablememory, int CPUspeed) {
		super(name);
		this.freeMemory = availablememory;
		this.cpuSpeed = CPUspeed;
	}
	
	public  boolean installApp(App app){
		
		if(installedApps.containsKey(app.getName()) || freeMemory<app.getMemoryReq() || app.getCpuReq()>cpuSpeed){
			return false;
		}
		
		installedApps.put(app.getName(), app.getMemoryReq());
		freeMemory=freeMemory- app.getMemoryReq();
		return true;
		
		
	}
	
	
	public boolean uninstallApp(App app){
		if(! installedApps.containsKey(app.getName())){
			return false;
		}
		
		installedApps.remove(app);
		freeMemory=freeMemory+ app.getMemoryReq();
		return true;
	}
	
	public boolean useApp(String name){
		if(!installedApps.containsKey(name) ||freeMemory<1){
			return false;
		}
		
		installedApps.put(name,installedApps.get(name)+1);
		freeMemory -=1;
		return true;
	}
	
	public ArrayList<String> getInstalledApps(){
		 ArrayList<String> result = new  ArrayList<String>();
		 
		Integer[] valueset = installedApps.values().toArray(new Integer[installedApps.size()]);
		
		 Arrays.sort(valueset);
		 
		 for(int i = valueset.length-1;i>=0;i--){
			 for(String str: installedApps.keySet()){
				 if(installedApps.get(str) == valueset[i]){
					 result.add(str);
				 }
			}
		}
		 return result;
	}
	
	public static void main(String[] args) {
		FruitySmartPhone p = new FruitySmartPhone("John Smith",100,10);
		p.installApp(new App("Camera",1,2));
		p.installApp(new App("Music",2,3));
		p.installApp(new App("Podcast",2,11));
		p.useApp("Music");
		System.out.println(p.getInstalledApps());
		System.out.println(installedApps);
	} 
}