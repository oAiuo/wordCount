package com.wordCount;

import java.io.*;

public class wordCount {
	public static void main(String[] args) throws IOException {
		if( args.length != 2)
		{
			System.out.println("-c filePath return charNum");
			System.out.println("-w filePath return wordNum");
			System.out.println("-l filePath return lineNum");
		}
		else {
			FileClass file = new FileClass(args[1]);
			
			switch(args[0]) {
				case "-c" :
					file.charNumCount();
					break;
					
				case "-w" :
					file.wordNumCount();
					break;
					
				case "-l" :
					file.lineNumCount();
					break;
				
				default :
					System.out.println("-c filePath return charNum");
					System.out.println("-w filePath return wordNum");
					System.out.println("-l filePath return lineNum");
			}
		}
	}
}



class FileClass {
	private File src;
	private BufferedReader input;
	
	public FileClass(String src) {
		this.src = new File(src);
		try {
			this.input = new BufferedReader(new FileReader(src));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found...\n");
		}

	}

	public void charNumCount() throws IOException {
		if(input == null)
			input = new BufferedReader(new FileReader(src));
		
		int charNum = 0, num = 0;
		char[] buffer = new char[1024];
		
		while( (num = input.read(buffer)) != -1 ) {
//			System.out.println("num = " + num);
			charNum += num;
			System.out.println(buffer);
		}
		
		System.out.println("charNum : " + charNum );
		input.close();
		input = null;

	}
	
	public void wordNumCount() throws IOException {
		if(input == null)
			input = new BufferedReader(new FileReader(src));
		
		int wordNum = 0;
		String str = null;
		
		while( (str = input.readLine()) != null ) {
			String[] arr = str.split("\\s+");
			for(String temp : arr) {
				System.out.println("word: " + temp);
				wordNum++;
			}
		}
		
		System.out.println("wordNum : " + wordNum );
		input.close();
		input = null;
		
	}
	
	public void lineNumCount() throws IOException {
		if(input == null)
			input = new BufferedReader(new FileReader(src));
		
		int lineNum = 0;
		
		while( input.readLine() != null )
			lineNum++;
		
		System.out.println("lineNum :  " + lineNum );
		input.close();
		input = null;
				
	}
}
