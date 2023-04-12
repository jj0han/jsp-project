<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


      <ul class="nav nav-tabs" id="myTab" role="tablist">
        <li class="nav-item">
          <a class="nav-link active" id="home-tab" aria-current="page" href="${pageContext.request.contextPath}">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" id="new-tab" href="${pageContext.request.contextPath}/public?acao=novo">Novo computador</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" id="list-tab" href="${pageContext.request.contextPath}/auth/admin?acao=listar">Listar computadores</a>
        </li> 
      </ul>