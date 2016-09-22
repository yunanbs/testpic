package example;

import userpicclient.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


/**
 * Created by YuNan on 2016/9/21.
 */
public class HelloWorldClient {
  public static void main(String[] argv) {
      try {

//          ceshi 123123
          GetDataImplServiceLocator service = new GetDataImplServiceLocator();
          IGetData client = service.getGetDataImplPort();
          User uu  = new User();
          Message msg = new Message("0",0,"PQ00192","HRS");
          RequestMessage req = new RequestMessage();
          req.setUser(uu);
          req.setNoun("allUserList");
          req.setVerb("Get");
          req.setMessage(msg);

          ResponseMessage result = client.getData(req);

          for (Result tmp:result.getResult()
               ) {
              byte[] bb = tmp.getPhoto();
              if(bb!=null){
                  String guid = java.util.UUID.randomUUID().toString();
                  String Filename = "C:\\pic\\"+guid+".png";

                  //确定写出文件的位置
                  File file = new File(Filename);

                  try {
                      FileOutputStream fos = new FileOutputStream(file);
                      fos.write(bb);
                      System.out.println("写入成功");
                      fos.close();
                  } catch (Exception e) {
                      e.printStackTrace();
                  }
          }
          }
          int a = 0;
      } catch (Exception ex) {
          ex.printStackTrace();
      }
  }
}
