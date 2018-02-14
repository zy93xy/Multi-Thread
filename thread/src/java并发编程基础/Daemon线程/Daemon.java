package java������̻���.Daemon�߳�;

import threadUtils.SleepUtils;

public class Daemon {
	public static void main(String[] args) {
		Thread thread = new  Thread(new DaemonRunner(),"DaemonRunner");
		thread.setDaemon(true);//ʹ��true���������߳�֮ǰִ��
		thread.start();
	}
	
	static class DaemonRunner implements Runnable{
		@Override
		public void run() {
			try{
				SleepUtils.second(10);
			}finally{
				System.out.print("DaemonThread finally run.");//��һ�в�����ֿ���̨
			}
			
		}
	}
}
