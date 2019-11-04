import React from 'react';
import ReactDOM from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import FormControl from 'react-bootstrap/FormControl';

import 'bootstrap/dist/css/bootstrap.min.css';

export default {
	component: Navbar,
	title: 'Navbar',
};

export const testNavbar  = ({ children }) => ( 
	<React.Fragment>
		<Navbar bg="dark" variant="dark" sticky="top">
			<Navbar.Brand href="#home">Blog</Navbar.Brand>
			<Nav className="mr-auto" variant="pills">
				<Nav.Link href="#home">About</Nav.Link>
        			<Nav.Link href="#features">Resume</Nav.Link>
        			<Nav.Link href="#pricing">Thoughts</Nav.Link>
        			<Nav.Link href="#pricing">Contact</Nav.Link>
      			</Nav>
    		<Form inline>
      			<FormControl type="text" placeholder="Search" className="mr-sm-2" />
      			<Button variant="outline-primary">Search</Button>
    		</Form>
    		</Navbar>
	</React.Fragment>
);
