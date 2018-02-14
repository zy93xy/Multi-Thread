package java并发编程基础;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {

	public static void main(String[] args) {
		//获取java线程管理MxBean
		ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();
		//不需要获取同步的monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
		ThreadInfo[] threadInfos = threadMxBean.dumpAllThreads(false, false);
		
		//遍历线程信息，
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println("【"+threadInfo.getThreadId()+"】"+threadInfo.getThreadName()+"线程状态："+threadInfo.getThreadState());
		}
		
	}

}
//【4】Signal Dispatcher线程状态：RUNNABLE   /*分发处理器发送给JVM信号的线程*/
//【3】Finalizer线程状态：WAITING            /*调用对象finalize的方法的线程*/
//【2】Reference Handler线程状态：WAITING    /*清除Reference的线程*/
//【1】main线程状态：RUNNABLE 				/*main线程，用户程序的入口

//一句话终结，由上面可以知道，一个java程序的运行不仅是main（）的 运行，还是有其他线程同时进行同时运行的；