package com.gunshop.gunshop;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GunRepo extends CrudRepository<Gun, Long> {
}
