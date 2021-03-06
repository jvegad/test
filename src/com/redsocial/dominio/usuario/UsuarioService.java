package com.redsocial.dominio.usuario;

import com.redsocial.persistencia.UsuarioDAO;
import java.util.Collection;

/**
 *
 * @author Leo
 */
public class UsuarioService {
    
    private UsuarioDAO dao = new UsuarioDAO();
           
    /**
    * Método crea un usuario en el sistema para publicar mascota
    * @param correoElectronico
    * @param clave
    * @throws com.redsocial.dominio.usuario.Exception
    */
    public void crearUsuario(String correoElectronico, String clave)throws Exception{
        
      try{
        
        //Validamos
        
        if (correoElectronico == null || correoElectronico.trim().isEmpty()){
          throw new Exception("Debe indicar el correo electrónico");  
        }
        
        if (correoElectronico.contains("@") == false){
          throw new Exception("El correo electrónico es incorrecto");  
        }
          
        if (clave == null || clave.trim().isEmpty()){
          throw new Exception("Debe indicar la clave");  
        }
        
        if (clave.length() < 8){
          throw new Exception("La clave no puede tener menos de 8 caracteres");  
        }
        
        
        try{
           buscarUsuarioPorCorreoElectronico(correoElectronico);
           throw new Exception("Ya existe un usuario con el correo electrónico indicado");
        }catch(Exception r){} 
        
        //Creamos el usuario
        Usuario usuario = new Usuario();
        usuario.setCorreoElectronico(correoElectronico);
        usuario.setClave(clave);
        
        dao.guardarUsuario(usuario);
        
      }catch(Exception e){
        e.printStackTrace();
        throw new Exception("Error de sistema");   
      } 
    }
    
    /**
    * Método que modficia la clave de usuario
    * @param correoElectronico
    * @param claveActual
    * @param nuevaClave
    * @throws com.redsocial.dominio.usuario.Exception
    */
    public void modificarClaveUsuario(String correoElectronico, String claveActual, String nuevaClave)throws Exception{
        
      try{
           
        //Validamos
        if (correoElectronico == null || correoElectronico.trim().isEmpty()){
          throw new Exception("Debe indicar el usuario");  
        }  
          
        if (claveActual == null || claveActual.trim().isEmpty()){
          throw new Exception("Debe indicar la clave actual");  
        }
        
        if (nuevaClave == null || nuevaClave.trim().isEmpty()){
          throw new Exception("Debe indicar la clave nueva");  
        }

        //Buscamos
        Usuario usuario = buscarUsuarioPorCorreoElectronico(correoElectronico);
        
        //Validamos
        if (!usuario.getClave().equals(claveActual)){
          throw new Exception("La clave actual no es la regsitrada en el sistema para el correo electrónico indicado");  
        }
        
        //Modificamos
        usuario.setClave(nuevaClave);
        
        dao.modificarUsuario(usuario);
        
      }catch(Exception e){
        e.printStackTrace();
        throw new Exception("Error de sistema");   
      } 
    }
    
    /**
    * Método que pertmite eliminar un usuario
    * @param correoElectronico 
    * @throws com.redsocial.dominio.usuario.Exception
    */
    public void eliminarUsuario (String correoElectronico)throws Exception{
        
      try{
      
         //Validamos 
         if (correoElectronico == null || correoElectronico.trim().isEmpty()){
          throw new Exception("Debe indicar el correo electrónico");  
         }
         
         dao.eliminarUsuario(correoElectronico);
          
      }catch(Exception e){
        e.printStackTrace();
        throw new Exception("Error de sistema");   
      }
    }
    
    /**
    * Método que pertmite buscar un usuario por correo electrónico
    * @param correoElectronico
    * @return reroena un usuario 
    * @throws com.redsocial.dominio.usuario.Exception
    */
    public Usuario buscarUsuarioPorCorreoElectronico(String correoElectronico)throws Exception{
        
        try{
            
            //Validamos
            if (correoElectronico == null || correoElectronico.trim().isEmpty()){
              throw new Exception("Debe indicar el correo electrónico");   
            }
            
            Usuario usuario = dao.buscarUsuarioPorCorreoElectronico(correoElectronico);

            //Verificamos
            if (usuario == null){
              throw new Exception("No se econtró usuario para el correo electrónico indicado");    
            }
            
            return usuario;
            
        }catch(Exception e){
          e.printStackTrace();
          throw new Exception("Error de sistema");   
        } 
    }
    
    public Collection<Usuario> listarUsuario()throws Exception{
        
        try{
            
            Collection<Usuario> usuarios = dao.listarUsuario();
           //mostrar
            return usuarios;
             
        }catch(Exception e){
          e.printStackTrace();
          throw new Exception("Error de sistema");   
        }
    }
  
    /**
    * Método que pertmite imprimir los usuarios
    * @throws com.redsocial.dominio.usuario.Exception
    */
    public void imprimirUsuarios()throws Exception{
        
      try{
        
        //Listamos los usuarios
        Collection<Usuario> usuarios = listarUsuario();
                
        //Imprimimos los usuarios
        if (usuarios.isEmpty()){
           throw new Exception("No existen usuarios para imprimir");  
        }else{
          for (Usuario u : usuarios){
              
            System.out.println(u.getCorreoElectronico());
            System.out.println(u.getClave());
            
          }  
        }  
      
      }catch(Exception e){
        e.printStackTrace();
        throw new Exception("Error de sistema");   
      } 
    }

}
