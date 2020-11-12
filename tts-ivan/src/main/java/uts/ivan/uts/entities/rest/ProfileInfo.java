/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.ivan.uts.entities.rest;

import lombok.Data;

/**
 *
 * @author ivanr
 */
@Data
public class ProfileInfo {
    private String id;
    private String name;
    private String birthDate;
    private String gender;
    private String email;
    
}
