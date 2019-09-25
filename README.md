<table>
<thead>
<tr>
<th align="center">Description</th>
</tr>
<br></br>
<tr><td align="left">This project usually is a simple combination of existing technologies. 
The following sample applications implements Batch reading csv file and write the content in H2 memory DataBase ,
and alow to launch the batch in one Shot mode by exposing url GET on navigator  (Spring-boot (data-jpa/web/test),batch,devtools, batch-test) </td>
</tr>
</thead>
<tbody>
<tr>
<td colspan="2"><strong>Java</strong></td>
</tr>
<br></br>
<tr>
<td><b>Batch processing with ,(Spring-boot(data-jpa/web/test),batch,devtools, batch-test) , H2 memory database </b>
<br></br>
 <br>* config programmatically batch ( item Reader,processor, writer )
 <br>* config H2 with auto create ddl with hbm2ddl 
 <br>* expose url GET (/load) ,to launch the batch processing : to reading csv file and write the content in H2 memory DataBase
 <br>* expose url GET (/purge),to launch the batch purge : to delete all rows in H2 memory DataBase

 <br></br>
 <br>* Url to launch one shot , batch processing :</br>
  <a href="http://localhost:8081/load"> http://localhost:8081/load</a>  
 <br>* Url to launch one shot , batch purge:</br>
  <a href="http://localhost:8081/purge">  http://localhost:8081/purge</a>
 <br>* console h2 :</br>
   <a href="http://localhost:8081/h2-console">http://localhost:8081/h2-console </a> 
    <br>* NB :(JDBC URL=jdbc:h2:mem:spring-batch)</br>
</td>
</tr>

<tr>
<td><br>* refer to :</br>
 <a href="https://spring.io/guides/gs/batch-processing/">https://spring.io/guides/gs/batch-processing/</a></td>  
</tr>
</tbody>
</table>