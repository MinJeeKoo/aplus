package model;

public class StatisticDTO {
	   private Integer stNo = null;			// ���PK
	   private Integer cNo = null;			// company FK
	   private Integer cfdNo = null;			// department FK
	   private Integer annual_Income = null;		// ����
	   private Integer InfoMood = null;		// �μ� ������
	   private Integer jobSat = null;			// ���� ������
	   private Integer cafeteria = null;			// ���� �Ĵ�
	   private Integer trafficConven = null;		// �������Ǽ�
	   private Integer empWellfare = null;		// ��������
	   
	   public Integer getStNo() 
	   {	return stNo;   }
	   
	   public void setStNo (Integer stNo)
	   {	this.stNo = stNo;       }

	    public Integer getCNo() 
	   {	return cNo;   }
	   
	   public void setCNO(Integer cNo) 
	   {	this.cNo = cNo;       }

	   public Integer getCfdNo() 
	   {	return cfdNo;	   }
	   
	   public void setCfdNo(Integer cfdNo) 
	   {	this.cfdNo = cfdNo;       }

	   public Integer getAnnual_Income() 
	   {	return this.annual_Income;      }

	   public void setAnnual_Income(Integer annual_Income) 
	   {	this.annual_Income = annual_Income;       }
	 
	   public Integer getInfoMood() 
	   {	return InfoMood;       }

	   public void setInfoMood(Integer InfoMood) 
	   {	this.InfoMood = InfoMood;       }

	   public Integer getJobSat() 
	   {	return jobSat;       }

	   public void setJobSat(Integer jobSat) 
	   {	this.jobSat = jobSat;      }

	   public Integer getCafeteria() 
	   {	return cafeteria;       }

	   public void setCafeteria(Integer cafeteria) 
	   {	this.cafeteria = cafeteria;       }

	   public Integer getTrafficConven() 
	   {	return trafficConven;       }

	   public void setTrafficConven(Integer trafficConven) 
	   {	this.trafficConven = trafficConven;       }

	   public Integer getEmpWellfare() 
	   {	return empWellfare;       }

	   public void setEmpWellfare(Integer empWellfare) 
	   {	this.empWellfare = empWellfare;      }
}
