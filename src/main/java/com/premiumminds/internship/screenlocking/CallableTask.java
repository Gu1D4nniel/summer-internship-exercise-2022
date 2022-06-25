package main.java.com.premiumminds.internship.screenlocking;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {


	private int patterns;

	public CallableTask(int patterns) {
		super();
		this.patterns = patterns;
		
	}

	@Override
	public Integer call() throws Exception {
		//Still to be properly implemented
		Thread.sleep(1000);
		return patterns;
	}

}
