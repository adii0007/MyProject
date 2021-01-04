package in.co.sunrays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.portable.ApplicationException;

import in.co.sunrays.bean.BaseBean1;
import in.co.sunrays.bean.SubjectBean1;
import in.co.sunrays.proj4.util.DataUtility1;
import in.co.sunrays.proj4.util.PropertyReader1;

public class SubjectListCtl1 extends BaseCtl1 {
	
	protected void preload(HttpServletRequest request) {
		
		SubjectModel1 model = new SubjectModel1();
		
		List subjectList = model.list(); 
		
		request.setAttribute("subjectList",subjectList);
			}
        
	
			
		@Override
		protected BaseBean1 populateBean(HttpServletRequest request) {
			SubjectBean1 bean = new SubjectBean1();
			
			bean.setId(DataUtility1.getLong(request.getParameter("subjectId")));
			bean.setName(DataUtility1.getString(request.getParameter("name")));
			bean.setDescription(DataUtility1.getString(request.getParameter("description")));
			bean.setCourseid(DataUtility1.getLong(request.getParameter("courseId")));

			return null;

		}


           
         @Override
         protected  void doGet(HttpServletRequest request,  HttpServletResponse response)
               throws ServletException , IOException {
        	 
        	int pageNo = 1;
        	int pageSize = DataUtility1.getInt(PropertyReader1.getValue("page.size"));
        	 
        	SubjectBean1 bean = (SubjectBean1) populateBean(request);
        	SubjectModel1 model = new SubjectModel1(); 
        	 
        	List list = null; 
        	 
        	try
        	{
        		list = model.search(bean, pageNo ,pageSize);
        	}
        	catch(ApplicationException e){
        		
        		
        	}
        	 
        	 
        	 
        	 
        	 
        	 
        	 
         }
}
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         

