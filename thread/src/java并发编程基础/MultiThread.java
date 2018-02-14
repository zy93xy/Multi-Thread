package java������̻���;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {

	public static void main(String[] args) {
		//��ȡjava�̹߳���MxBean
		ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();
		//����Ҫ��ȡͬ����monitor �� synchronizer ��Ϣ������ȡ�̺߳��̶߳�ջ��Ϣ
		ThreadInfo[] threadInfos = threadMxBean.dumpAllThreads(false, false);
		
		//�����߳���Ϣ��
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println("��"+threadInfo.getThreadId()+"��"+threadInfo.getThreadName()+"�߳�״̬��"+threadInfo.getThreadState());
		}
		
	}

}
//��4��Signal Dispatcher�߳�״̬��RUNNABLE   /*�ַ����������͸�JVM�źŵ��߳�*/
//��3��Finalizer�߳�״̬��WAITING            /*���ö���finalize�ķ������߳�*/
//��2��Reference Handler�߳�״̬��WAITING    /*���Reference���߳�*/
//��1��main�߳�״̬��RUNNABLE 				/*main�̣߳��û���������

//һ�仰�սᣬ���������֪����һ��java��������в�����main������ ���У������������߳�ͬʱ����ͬʱ���еģ�