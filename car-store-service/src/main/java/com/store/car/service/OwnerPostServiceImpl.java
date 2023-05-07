package com.store.car.service;

import com.store.car.dto.OwnerPostDTO;
import com.store.car.entity.OwnerPostEntity;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {
        OwnerPostEntity ownerPost = new OwnerPostEntity();
        ownerPost.setName(ownerPostDTO.getName());
        ownerPost.setType(ownerPost.getType());
        ownerPost.setContactNumber(ownerPostDTO.getContactNumber());

        ownerPostRepository.save(ownerPost);
    }
}
