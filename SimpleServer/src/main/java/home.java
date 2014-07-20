

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dips.base.MyHtml;
import com.dips.demo.FileExt;

import java.io.ByteArrayOutputStream;

/**
 * Servlet implementation class GetFile
 */
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String rid="";
		rid=request.getSession().getId();
    	PrintWriter pw=response.getWriter();
		MyHtml mh=new MyHtml(pw);
		mh.WriteHeader();
		FileExt fe=(FileExt)request.getSession().getAttribute("FileExt");
//		mh.writeT("hidden", "rid",rid);
		mh.writeS("欢迎："+request.getSession().getAttribute("title"));
//		mh.WriteA("CleanCookie", "退出");
		mh.writeS("当前目录为："+fe.getName());
		mh.writeS("<br/>");
		mh.writeS("内容为：");
		mh.writeS("<br/>");
		mh.writeS(fe.getContent());
		mh.WriteA("edit?rid="+rid, "编辑");
		mh.WriteA("add?rid="+rid, "添加");
		mh.WriteA("Delete?rid="+rid, "删除");
		mh.WriteA("Return?rid="+rid, "返回上一级");
		mh.writeS("<p>");
		ArrayList<String> strArray=fe.subFile;
		for(int i=0;i<strArray.size();i++){
			mh.WriteA("GetFile?FileName="+strArray.get(i)+"&rid="+rid, strArray.get(i));
			mh.writeS("<br/>");
		}
		mh.WriteEnd();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
