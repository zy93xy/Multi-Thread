package volatile������;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExampleTest {
	int a = 0;
	ReentrantLock reentrantLock = new ReentrantLock();
	
	public void writer(){
		reentrantLock.lock();//��ȡ��
		 
		try {
			a++;
//			System.out.println("�̶߳���a="+a);
		}finally{
			reentrantLock.unlock();//�ͷ���
		}
		
	}
	
	public void reader(){
		reentrantLock.lock();//��ȡ��
		
		try {
			int i = a;
			System.out.println("�̶߳���a="+a);
		}finally{
			reentrantLock.unlock();//�ͷ���
		}
	}
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			long starttime = System.currentTimeMillis();
			 final Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					ReentrantLockExampleTest rle = new ReentrantLockExampleTest();
					rle.writer();
					rle.reader();
					
				}
			});
			 t.start();
//			 t.sleep(5000);//���߳�֮���ߣ�����������ִ�еĳ��������þ�Ȼ����
//			 t.checkAccess(); //����ʹ��û���κ�����
//			 t.countStackFrames();//��ʱ
//			 t.destroy();//��ʱ
//			 t.getStackTrace();
//			 System.out.println("ReentrantLockExampleTest.main()"+t.isAlive());//���������֮���һִ��Ϊtrue�ǾͿ��Ծ�Ȼ�����ִ�г���������
//			 System.out.println("    "+t.isDaemon()); //ִ��Ϊfalse�����Ǿ�Ȼ����
//			 t.join();//ʹ����Ҳ�Ǿ�Ȼ�����
//			 t.wait(5000); //
			 long endTime = System.currentTimeMillis();
			 System.out.println("���ƣ�"+t.getName()+"��ʱ���룺"+(endTime - starttime));
			}

	}

}
