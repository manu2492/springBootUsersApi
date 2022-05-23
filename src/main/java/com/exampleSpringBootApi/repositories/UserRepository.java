package com.exampleSpringBootApi.repositories;

import java.util.ArrayList;

import com.exampleSpringBootApi.models.UserModel;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

    public abstract ArrayList<UserModel> findByPriority(Integer prioridad);
    
}
