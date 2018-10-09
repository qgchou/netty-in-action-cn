package nia.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * BlockingIoExample 代码1-1对应的客户端
 */
public class XBlockingIoExampleClient
{
	public static void main(String[] args) throws IOException
	{
		Socket socket = new Socket("127.0.0.1", 30000);

		PrintStream ps = new PrintStream(socket.getOutputStream());
		BufferedReader br = null;

		Scanner scan = new Scanner(System.in);
		// 不断读取键盘输入
		while (scan.hasNextLine())
		{
			ps.println(scan.nextLine());
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			// 进行普通IO操作
			String line = br.readLine();
			System.out.println("来自服务器的数据：" + line);
		}
		// 关闭输入流、socket
		br.close();
		socket.close();
	}
}
