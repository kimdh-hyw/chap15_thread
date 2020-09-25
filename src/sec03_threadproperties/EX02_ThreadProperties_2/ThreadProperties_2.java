package sec03_threadproperties.EX02_ThreadProperties_2;

//우선순위

class MyThread extends Thread {
	@Override
	public void run() {
		for(long i=0; i<1000000000 ; i++) { } //시간 지연용
		System.out.println(getName() + "  우선순위 : "+ getPriority());		
	}
}

public class ThreadProperties_2 {
	public static void main(String[] args) {
		
		//#참고. CPU core
		System.out.println("코어수 : "+ Runtime.getRuntime().availableProcessors()); //
		
		//#1. 디폴트 우선순위
		for(int i=0; i<3; i++) {
			Thread thread = new MyThread();
			thread.start();
		}
		
		//#2. 우선순위를 직접 지정
		for(int i=0; i<10; i++) {
			Thread thread = new MyThread();
			thread.setName(i+"번째 쓰레드");
			if(i==9) thread.setPriority(10);
			thread.start();
		}
		
	}
}
