# jersey_demo

sample jersey maven project for lean this . 

use jersey build sample RESTful service.

>blog:
[Jersey构建RESTful后台服务 ](http://blog.csdn.net/xvshu/article/details/77261630)

# RESTful
>REST（英文：Representational State Transfer，简称REST）描述了一个架构样式的网络系统，比如 web 应用程序。它首次出现在 2000 年 Roy Fielding 的博士论文中，他是 HTTP 规范的主要编写者之一。在目前主流的三种Web服务交互方案中，REST相比于SOAP（Simple Object Access protocol，简单对象访问协议）以及XML-RPC更加简单明了，无论是对URL的处理还是对Payload的编码，REST都倾向于用更加简单轻量的方法设计和实现。值得注意的是REST并没有一个明确的标准，而更像是一种设计的风格。

# Jersey
>Jersey RESTful 框架是开源的RESTful框架, 实现了JAX-RS (JSR 311 & JSR 339) 规范。它扩展了JAX-RS 参考实现， 提供了更多的特性和工具， 可以进一步地简化 RESTful service 和 client 开发。尽管相对年轻，它已经是一个产品级的 RESTful service 和 client 框架。

# 引入步骤
+ 加入Jersey引用
```
    <dependency>
      <groupId>org.glassfish.jersey.containers</groupId>
      <artifactId>jersey-container-servlet</artifactId>
      <version>2.17</version>
    </dependency>
    <dependency>
      <groupId>org.glassfish.jersey.core</groupId>
      <artifactId>jersey-client</artifactId>
      <version>2.17</version>
    </dependency>
    <dependency>
      <groupId>org.glassfish.jersey.media</groupId>
      <artifactId>jersey-media-json-jackson</artifactId>
      <version>2.17</version>
    </dependency>
```

+ 修改web.xml
```
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
  <display-name>jerseyDemo</display-name>

  <servlet>
    <servlet-name>jersey-restful</servlet-name>
    <servlet-class>
      org.glassfish.jersey.servlet.ServletContainer
    </servlet-class>
    <init-param>
      <param-name>jersey.config.server.provider.packages</param-name>
      <param-value>com.xvshu.cn</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>jersey-restful</servlet-name>
    <url-pattern>/rest/*</url-pattern>
  </servlet-mapping>

</web-app>
```

+ 新增rest服务

```
package com.xvshu.cn.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by xvshu on 2017/8/16.
 */
@Path("/user")
public class UserRestServide {

    @GET
    @Path("/{from}/{userName}/{passWord}")
    @Produces("text/plain;charset=UTF-8")
    public String sayHello2UserByText(@PathParam("userName") String username,@PathParam("passWord") String passWord,@PathParam("from") String from) {
        String result = "false";

        System.out.println("==>rest/from:"+String.valueOf(from)+" user:"+String.valueOf(username)+" pass:"+String.valueOf(passWord));
        username=username.trim();
        passWord=passWord.trim();
        if(username.equals("admin") && passWord.equals("admin")){
            result="true";
        }
        return result;
    }
}

```

+ 发布
项目正常打包发布至tomcat，完成部署
