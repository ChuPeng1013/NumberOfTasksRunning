package com.chupeng.running;

import java.util.ArrayList;
import java.util.List;

public class CalculateRunning 
{
	public int[] getNumberOfTasksRunning(int n, int m, int[] start, int[] end, int[] query)
	{
		//依次判断n(任务数)，m(时间数)，start(开始时间)，end(结束时间)，query(查询时间)的合法性
		if(n != start.length || n != end.length)
		{
			System.out.println("n(任务数)、start(开始时间)、end(结束时间)不相等，请重新输入！");
			return null;
		}
		else if(start.length != end.length)
		{
			System.out.println("start(开始时间)、end(结束时间)不相等，请重新输入！");
			return null;
		}
		else if(m != query.length)
		{
			System.out.println("m(时间数)、query(查询时间)不相等，请重新输入！");
			return null;
		}
		else
		{
			for(int i = 0; i < start.length; i++)
			{
				if(start[i] < 0)
				{
					System.out.println("start(开始时间)不能小于0，请重新输入！");
					return null;
				}
			}
			
			for(int i = 0; i < end.length; i++)
			{
				if(end[i] < 0)
				{
					System.out.println("end(结束时间)不能小于0，请重新输入！");
					return null;
				}
			}
			
			for(int i = 0; i < query.length; i++)
			{
				if(query[i] < 0)
				{
					System.out.println("query(查询时间)不能小于0，请重新输入！");
					return null;
				}
			}
		}
		//分配每个任务执行的时间区间
		List<String> taskList = getTaskRunningInterval(n, start, end);
		//获取查询的时刻有几个任务在执行
		int[] outPut = getTaskRunningNumber(taskList, m, query);
		return outPut;
	}
	
	public String convertFormat(int[] outPut)
	{
		//判断参数的合法性
		if(outPut == null)
		{
			return null;
		}
		StringBuilder outPutString = new StringBuilder("[");
		for(int i = 0; i < outPut.length - 1; i++)
		{
			outPutString.append(outPut[i]);
			outPutString.append(",");
			outPutString.append(" ");
		}
		outPutString.append(outPut[outPut.length - 1]);
		outPutString.append("]");
		return outPutString.toString();
	}
	
	//分配每个任务执行的时间区间
	private List<String> getTaskRunningInterval(int n, int[] start, int[] end)
	{
		List<String> taskList = new ArrayList<>();
		for(int i = 0; i < n; i++)
		{
			StringBuilder interval = new StringBuilder();
			interval.append(start[i]);
			interval.append(",");
			interval.append(end[i]);
			taskList.add(interval.toString());
		}
		return taskList;
	}
	
	private int[] getTaskRunningNumber(List<String> taskList, int m, int[] query)
	{
		if(taskList == null)
		{
			return null;
		}
		//获取查询的时刻有几个任务在执行
		int[] outPut = new int[m];
		for(int i = 0; i < m; i++)
		{
			int quertTime = query[i];
			int times = 0;
			for(int j = 0; j < taskList.size(); j++)
			{
				String intervalString = taskList.get(j);
				String[] interval = intervalString.split(",");
				if(quertTime >= Integer.parseInt(interval[0]) && 
						quertTime < Integer.parseInt(interval[1]))
				{
					times = times + 1;
				}
			}
			outPut[i] = times;
		}
		return outPut;
	}
}
