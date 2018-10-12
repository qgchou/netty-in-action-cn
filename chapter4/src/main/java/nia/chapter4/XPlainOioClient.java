package nia.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * XPlainOioClient 代码4-1对应的客户端
 */
public class XPlainOioClient
{
	public static void main(String[] args) throws IOException
	{
		Socket socket = new Socket("127.0.0.1", 30000);

		BufferedReader br = null;
		br = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		// 进行普通IO操作
		String line = br.readLine();
		System.out.println("来自服务器的数据：" + line);
		// 关闭输入流、socket
		br.close();
		socket.close();
	}
}
