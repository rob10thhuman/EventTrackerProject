## EVENT TRACKER ##

ROUTES:

http://18.223.18.233:8080/NovEventTrackerRest/api/ping
Returns pong

http://18.223.18.233:8080/NovEventTrackerRest/api/posts/
Returns all posts

http://18.223.18.233:8080/NovEventTrackerRest/api/posts/{id}
Returns a post - currently two in the db (1 or 2)


//the method I knew
	@RequestMapping(path="posts", method=RequestMethod.POST)
	public Post create(@RequestBody Post post) {
		post = postDAO.create(post);
		return post;
	}

	//the method we learned
	@RequestMapping(path="posts/rest", method=RequestMethod.POST)
	public Post createRestPost(@RequestBody Post post) {
		return pSvc.create(post);
	}

  The two routes above I mapped. The first uses a DAO but I wanted to implement via the rest method as well. Both work to create a post.


	@DeleteMapping(path="posts/{id}")
	public boolean destroy(@PathVariable("id") Integer id) {
		return pSvc.deleteById(id);

	}

  The above mapping removes a post.

	@PatchMapping("post/{id}")
	public Post update(@RequestBody Post post, @PathVariable("id") Integer id) {
		pSvc.updatePost(post, id);
		return post;

	}

  This method updates a post
