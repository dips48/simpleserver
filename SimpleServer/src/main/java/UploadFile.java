

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dips.demo.FileExt;
import com.dips.demo.FileUpload;

import java.io.ByteArrayOutputStream;

/**
 * Servlet implementation class UploadFile
 */
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		FileExt fe=(FileExt)request.getSession().getAttribute("FileExt");
		String str=fe.getName();
		FileUpload fu=new FileUpload();
		fu.setFilePath(fe.getPath());
		fu.setFileName(str);
		fu.setOperation(1);
		fu.setContent("  "+request.getParameter(str));
		try{
		SocketChannel sc=SocketChannel.open();
		sc.connect(new InetSocketAddress(2001));
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		ObjectOutputStream oout=new ObjectOutputStream(out);
		oout.writeObject(fu);
		oout.flush();
		byte[] obArray=out.toByteArray();
		ByteBuffer buf=ByteBuffer.allocate(obArray.length);
		buf.put(obArray);
		buf.flip();
		sc.write(buf);
		sc.close();
		}catch(Exception e){
			request.setAttribute("errorinfor", "�������޷�����");
			response. sendRedirect ("error.jsp") ;
		}
		
		fe.setPath(fu.getFilePath());
		fe.setName(fu.getFileName());
		fe.setContent(fu.getContent());
		request.getSession().setAttribute("FileExt", fe);
		response. sendRedirect ("home") ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
