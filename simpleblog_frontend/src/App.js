import React, { Component } from 'react';
import './App.css';
import Blogposts from './components/Blogposts';

class App extends Component {
	state = {
		posts: [
			{
				id: 1,
				title: "Test",
				body: "Testing123"
			},
			{
				id: 2,
				title: "Test2",
				body: "Testing1235"
			}
		]
	}
	render () {
		return (
			<div className="App">
				<Blogposts posts={this.state.posts} />
			</div>
			);
	}
}

export default App;
