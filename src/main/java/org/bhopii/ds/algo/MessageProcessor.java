package org.bhopii.ds.algo;

public class MessageProcessor {
	public boolean stop = false;
	public static void main(String[] args) throws InterruptedException{
		
		long startTime = System.currentTimeMillis();
		
		MessageProcessor processor = new MessageProcessor();
		processor.startProcessing();
		Thread.sleep(10000);
		processor.stopProcessing();
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
	}
	
	private void stopProcessing() {
		System.out.println("Stop Processing invoked");
		stop = true;
	}
	
	private void startProcessing() {
		new Thread(()-> {
			System.out.println("Message processor started");
			while(!stop) {
				processMessage();
			}
			System.out.println("Message Processor stopped");
		}).start();
	}

	private void processMessage() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
