package main.java.com.premiumminds.internship.screenlocking;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {


	@Override
	public Integer call() throws Exception {
		Thread.sleep(1000);
		return 5;
	}

}
