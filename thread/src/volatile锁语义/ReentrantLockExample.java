package volatile������;

import java.util.concurrent.locks.ReentrantLock;

//public class ReentrantLockExample {
//		int a = 0;
//		ReentrantLock reentrantLock = new ReentrantLock();
//		
//		public void writer(Thread t){
//			reentrantLock.lock();//��ȡ��
//			try {
//				a++;
//				
//			}finally{
//				reentrantLock.unlock();//�ͷ���
//			}
//			
//		}
//		public void reader(Thread t){
//			reentrantLock.lock();//��ȡ��
//			try {
//				int i = a;
//				System.out.println("�̶߳���"+t.getName()+"a="+a);
//			}finally{
//				reentrantLock.unlock();//�ͷ���
//			}
//		}
//		public static void main(String[] args){
//			for (int i = 0; i < 1000; i++) {
//			long starttime = System.currentTimeMillis();
//			 final Thread t = new Thread(new Runnable() {
//				@Override
//				public void run() {
//					ReentrantLockExample rle = new ReentrantLockExample();
//					rle.writer(t);
//					rle.reader(t);
//				}
//			});
//			 t.start();
//			long endTime = System.currentTimeMillis();
//			System.out.println("�߳�������"+i+"�����ƣ�"+t.getName()+"��ʱ���룺"+(endTime - starttime));
//			}
//		}��
//}������
