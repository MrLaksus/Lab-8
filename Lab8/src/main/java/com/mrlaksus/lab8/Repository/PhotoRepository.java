package com.mrlaksus.lab8.Repository;

import com.mrlaksus.lab8.Entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}

