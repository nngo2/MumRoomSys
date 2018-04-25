package edu.mum.roomsys.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;

import edu.mum.roomsys.domain.BookItem;
import edu.mum.roomsys.logging.ILogger;

@Aspect
@Component
public class CheckinAdvice {

	@Autowired
	private ILogger logger;

	public CheckinAdvice() {
		super();
	}

	@Around("execution(* edu.mum.roomsys.controller.CheckinController.createCheckin(..)) && args (bookItemToBeAdded, model)")
	public Object checkinMonitor(ProceedingJoinPoint call, BookItem bookItemToBeAdded, Model model) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object obj = call.proceed();
		logger.log("Checkin process executed: " + call.getSignature().getName());
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		logger.log("New Check in created for Student: " + bookItemToBeAdded.getBooking().getStudent().getName()
				+ " for Building: " + bookItemToBeAdded.getBooking().getRoom().getBuildNumber());
		logger.log("Time spent in Checkin process: " + totaltime + " ms");
		return obj;
	}

}
