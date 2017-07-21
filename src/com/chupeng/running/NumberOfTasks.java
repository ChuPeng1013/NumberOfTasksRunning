package com.chupeng.running;

public class NumberOfTasks 
{
	public static void main(String args[]) 
	{
		//初始化参数
		int n = 3;
		int m = 4;
		int[] start = {0,5,2};
		int[] end = {4,7,8};
		int[] query = {1,9,4,3};
		CalculateRunning calculateRunning = new CalculateRunning();
		//获取给定时间运行的任务数
		int[] outPut = calculateRunning.getNumberOfTasksRunning(n, m, start, end, query);
		//转换任务数的格式
		String outPutString = calculateRunning.convertFormat(outPut);
		if(null == outPutString)
		{
			return;
		}
		//打印给定时间运行的任务数
		System.out.println(outPutString);
    }
}
