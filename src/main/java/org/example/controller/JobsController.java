package org.example.controller;


import jakarta.ws.rs.*;
import org.example.dao.JobDAO;
import org.example.models.Jobs;

import java.sql.*;
import java.util.ArrayList;
@Path("/jobs")
public class JobsController {

    JobDAO dao = new JobDAO();

    @GET
    public ArrayList<Jobs> selectAllDepts(){
        try {
            return dao.selectAllDepts();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("{jobId}")
    public Jobs getJobs(@PathParam("jobId") int jobId) {

        try {
            return dao.selectJobs(jobId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DELETE
    @Path("{jobId}")
    public void deleteJobs(@PathParam("jobId") int jobId) {

        try {
             dao.deleteJobs(jobId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    public void insertJobs(Jobs job) {

        try {
            dao.insertJobs(job);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("{jobId}")
    public void updateJobs(@PathParam("jobId") int jobId,Jobs job) {

        try {
            job.setJobID(jobId);
            dao.updateJobs(job);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
