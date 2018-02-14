package java中实现原子操作;

import java.util.ArrayList;
import java.util.List;

//import org.w3c.dom.css.Counter;



public class CasAndAtomic {
	private int i = 0;
	
	public static void main(String[] args) {
//		final Counter cas = new Counter();//这种写法什么x
		List<Thread> ts = new ArrayList<Thread>(600);
		Long start = System.currentTimeMillis();
		for (int j = 0; j < 100; j++) {
			Thread t = new Thread(new Runnable(){

				@Override
				public void run() {
					for (int i = 0; i < 1000; i++) {
//						cas.count();
//						cas.safeCount();
					}
				}
				
			});
			ts.add(t);
		}
		for (Thread thread : ts) {
			thread.start();
		}
		//等待所有的线程执行完成
		for (Thread thread : ts) {
			try {
				thread.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		System.out.println(cas.i);
//		System.out.println(cas.atomic.get());
		System.out.println(System.currentTimeMillis() - start);	
		 
	}
	
	private void count(){
		i++;
	}

}
