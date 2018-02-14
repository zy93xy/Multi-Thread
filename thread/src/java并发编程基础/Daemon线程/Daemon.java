package java并发编程基础.Daemon线程;

import threadUtils.SleepUtils;

public class Daemon {
	public static void main(String[] args) {
		Thread thread = new  Thread(new DaemonRunner(),"DaemonRunner");
		thread.setDaemon(true);//使用true，在启动线程之前执行
		thread.start();
	}
	
	static class DaemonRunner implements Runnable{
		@Override
		public void run() {
			try{
				SleepUtils.second(10);
			}finally{
				System.out.print("DaemonThread finally run.");//这一行不会出现控制台
			}
			
		}
	}
}
