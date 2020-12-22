package sec03_threadproperties.EX01_ThreadProperties_1;

//쓰레드 객체 가져오기/ 이름설정/ 쓰레드 수 

public class ThreadProperties_1 {	
	public static void main(String[] args) {
		
		//#1. 객체가져오기 (currentThread()) / 쓰레드 수 (activeCount())
		Thread curThread = Thread.currentThread();
		System.out.println("현재 쓰레드의 이름 = " + curThread.getName());
		System.out.println("동작하는 쓰레스 수 = " + Thread.activeCount());
		
		//#2. 쓰레드 이름 지정 (자동지정)
		for(int i=0; i<3; i++) {
			Thread thread = new Thread();
			System.out.println(thread.getName());
			thread.start();
		}
		
		//#3. 쓰레드 이름 직접 지정
		for(int i=0; i<3; i++) {
			Thread thread = new Thread();
			thread.setName(i+"번째 쓰레드");
			System.out.println(thread.getName());
			thread.start();
		}
		
		//#4. 쓰레드 이름 지정 (자동지정)
		for(int i=0; i<3; i++) {
			Thread thread = new Thread();
			System.out.println(thread.getName());
			thread.start();
		}
		
		//#5. 쓰레드 수 
		System.out.println("동작하는 쓰레스 수 = " + Thread.activeCount());		
	}
}
