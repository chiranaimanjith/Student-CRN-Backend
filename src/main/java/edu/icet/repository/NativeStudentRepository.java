package edu.icet.repository;

public interface NativeStudentRepository {
    Long getRecordCount();

    Long getRecordCount(String age);
}
