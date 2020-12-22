package sec03_threadproperties.EX03_ThreadProperties_3_1;

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println(getName() + " : " + (isDaemon()? "데몬쓰레드":"일반쓰레드") );
		for(int i =0; i<6; i++) {
			System.out.println(getName() + " : " + i + "초");
			try{Thread.sleep(1000);}catch(InterruptedException e) {}
		}
	}
}

public class ThreadProperties_3_1 {
	public static void main(String[] args) {
		
		//# 일반쓰레드
		Thread thread1 = new MyThread();
		thread1.setDaemon(false);//디폴트
		thread1.setName("thread1");
		thread1.start();
				
		//# 3초후 main Thread 종료
		try {Thread.sleep(3100);} catch (InterruptedException e) {}
		System.out.println("main Thread 종료");
	}
}









