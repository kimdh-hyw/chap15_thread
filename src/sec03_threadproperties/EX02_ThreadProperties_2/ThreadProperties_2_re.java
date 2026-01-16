/*쓰레드의 우선순위(priority)*/

//우선순위
class MyThread extends Thread {
	@Override
	public void run() {
		long sum=0;
		for(long i=0; i<1_000_000_000 ; i++) { 
			sum+=i;
		} //시간 지연용
		System.out.println(getName() + " 우선순위 : "+ getPriority());		
	}
}

public class ThreadProperties_2_re {
	public static void main(String[] args) throws InterruptedException {
		
		//#참고. CPU core
		System.out.println("코어수 : "+ Runtime.getRuntime().availableProcessors()); //
		
		//#1. 디폴트 우선순위
		for(int i=0; i<3; i++) {
			Thread thread = new MyThread();
			thread.start();
		}
		
		try { Thread.sleep(1000); } catch (InterruptedException e) {}
		
		//#2. 2개 쓰레드 생성 및 우선순위를 직접 지정
		Thread thread_lowPriority = new MyThread();
		thread_lowPriority.setPriority(Thread.MIN_PRIORITY);
		thread_lowPriority.setName("LowPriority 쓰레드");
		
		Thread thread_highPriority = new MyThread();
		thread_highPriority.setPriority(Thread.MAX_PRIORITY);
		thread_highPriority.setName("HighPriority 쓰레드");
		
		
		//#3. 낮은 우선순위 쓰레드 먼저 시작 + 1ms 지연 + 높은 우선순위 쓰레드 시작
		thread_lowPriority.start(); //낮은 priority 먼저 시작
		Thread.sleep(1);
		thread_highPriority.start();//높은 priority 먼저 시작
		
	}
}
