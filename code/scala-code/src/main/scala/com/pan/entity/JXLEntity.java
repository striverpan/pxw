package com.pan.entity;

/**
 * Created by pan on 2017/8/23.
 */
public class JXLEntity {

    private String enEntityName;
    private String cnEntityName;
    private String remark;


    public JXLEntity(String enEntityName, String cnEntityName, String remark) {
        this.enEntityName = enEntityName;
        this.cnEntityName = cnEntityName;
        this.remark = remark;
    }

    public String getEnEntityName() {
        return enEntityName;
    }

    public void setEnEntityName(String enEntityName) {
        this.enEntityName = enEntityName;
    }

    public String getCnEntityName() {
        return cnEntityName;
    }

    public void setCnEntityName(String cnEntityName) {
        this.cnEntityName = cnEntityName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "{" +
                "\"enEntityName\":" +"\""+ enEntityName + '\"' +
                ", \"cnEntityName\":" +"\""+ cnEntityName + '\"' +
                ", \"remark\":" +"\""+ remark + '\"' +
                '}';
    }
}
