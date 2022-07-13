package io.hongyang.checkito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckitoRepository extends JpaRepository<Checkito, Long> {}
