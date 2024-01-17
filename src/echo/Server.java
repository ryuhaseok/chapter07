package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		//서버 소켓 생성
		ServerSocket serverSocket = new ServerSocket();
		
		//바인딩
		serverSocket.bind(new InetSocketAddress("192.168.0.41", 10001));
		
		//서버시작
		System.out.println("<서버시작>");
		System.out.println("===============================================");
		
		//반복
		while(true) {
			
			System.out.println("[연결을 기다리고 있습니다.]");
			
			//클라이언트가 접속을 하면 accept()가 실행됨
			Socket socket = serverSocket.accept();
			
			Thread thread = new ServerThread(socket);
			thread.start();
			System.out.println("[클라이언트가 연결 되었습니다.]");
			
		}
		
		/*
		System.out.println("===================================");
		System.out.println("<서버 종료>");
		
		//닫기
		bw.close(); //외부로 연결된 것은 닫아주는 것이 좋다
		br.close();
		socket.close();
		serverSocket.close();
		*/
		
	}

}
